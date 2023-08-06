package OSIMacro;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelMnr {
	  
	public String filePath;
	
	public String fileName; 
	
	public List<ExcelDto> getProductList(String siteurl) throws EncryptedDocumentException,IOException, InvalidFormatException{
		
		List<ExcelDto> ProductList = new ArrayList<ExcelDto>();
		
		//String filePath = "C:/Users/my140225/Desktop";
		//String  fileName="b.xlsx";
		
		File file = new File(siteurl);
		FileInputStream inputStream = new FileInputStream(file);//new File(filePath , fileName)
		//OPCPackage opc= OPCPackage.open(new File(filePath+"a.xlsx"));file1
		
		
		//엑셀 읽기.
		//Workbook workbook = (XSSFWorkbook)WorkbookFactory.create(opc);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		
		//FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
		//시트 첫번째 로드 S
		XSSFSheet sheet = workbook.getSheetAt(0);
				Iterator<Row> rowItr = sheet.iterator();
				//행만큼 반복
				
				while (rowItr.hasNext()) {
					ExcelDto EDto = new ExcelDto(); //엑셀 값 넣을 객체
					
					XSSFRow row = (XSSFRow) rowItr.next();
					
					
					//첫행이 헤더일경우 2번째 행부터 data 로드
					/* if (row.getRowNum() <= 0) {
						 continue; 
					 }*/
					 
					Iterator<Cell> cellItr = row.cellIterator();
					//열 만큼 반복
					while (cellItr.hasNext()) {
							Cell cell = cellItr.next();
							int index = cell.getColumnIndex(); 
							//System.out.println("index="+ index);
								switch (index) {
								 // 0,1,2,3,4,5 index
									case 1: 
										EDto.setProduct_name((String) getValueFromCell(cell));
										System.out.println("rownum"+row.getRowNum());
										System.out.println((String) getValueFromCell(cell));
										//System.out.println("품목="+(String) getValueFromCell(cell));
									break;
									case 5: 
										// Double형으로 변환 후 int형으로 변환
										//EDto.setMoney(Double.parseDouble((String) getValueFromCell(cell)));//.intValue()
										System.out.println("값="+getValueFromCell(cell));
										if(getValueFromCell(cell)== null || getValueFromCell(cell) == "" || getValueFromCell(cell).equals(" ") ||getValueFromCell(cell).equals("")) {
											EDto.setMoney(0);
										}else {
											
											String numberString = String.valueOf(getValueFromCell(cell));
											String newnumber = numberString.replaceAll("[^0-9.]", "");
											System.out.println("값2:"+newnumber);
											//EDto.setMoney((int)Double.parseDouble(String.valueOf(newnumber)));
											EDto.setMoney((int)Double.parseDouble(newnumber)); 
										}
										//System.out.println(getValueFromCell(cell));
										//System.out.println("단가="+((Double) getValueFromCell(cell)).intValue());
									break;
									/*case 2: 
									student.setBirthDate((Date) getValueFromCell(cell));
				                    break;*/
									}
								
					}
					ProductList.add(EDto);
				}
		return ProductList;
	} 
	
	private Object getValueFromCell(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue();
		case NUMERIC:
			if(DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			}
			return cell.getNumericCellValue();
		case FORMULA:
			return  cell.getCellFormula();
		case BLANK:
			return "";
		default:
			return "";
		}
	}
}