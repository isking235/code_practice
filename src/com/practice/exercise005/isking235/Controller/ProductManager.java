package com.practice.exercise005.isking235.Controller;

import java.util.TreeMap;

import com.practice.exercise005.isking235.exception.SoldOutException;
import com.practice.exercise005.isking235.vo.Product;

/**
 * @author Administrator
 * 싱글톤
 */
public class ProductManager {
	private static ProductManager productManager = new ProductManager();
	TreeMap<String, Product> productMap = null;
	
	private ProductManager(){
		//최초실행시 상품 목록을 생성한다.
		loadProduct();
	}
	public static ProductManager getInstance(){
		return productManager; 
	}
	
	/**
	 * 보유 상품을 생성 하는 함수
	 */
	private void loadProduct() {
		
		this.productMap = new TreeMap<String, Product>();
		productMap.put("24771911", new Product("24771911", "KFC치킨불고기콤보", 2600, 27));
		productMap.put("24756487", new Product("24756487", "소다/카시오패션스포츠시계", 49800, 2));
		productMap.put("24750911", new Product("24750911", "[목동]육감숯불구이", 21600, 4));
		productMap.put("24718904", new Product("24718904", "[정자]박종일프로헤어", 29000, 1));
		productMap.put("24703223", new Product("24703223", "[구로디지털]LA식당", 30000, 29));
		productMap.put("24702630", new Product("24702630", "고려홍삼명가명기홍삼정", 65300, 1));
		productMap.put("24692301", new Product("24692301", "쿠쿠압력밥속", 21000, 2));
		productMap.put("24671273", new Product("24671273", "나이키BEST런닝화22종", 45000, 20));
		productMap.put("24670532", new Product("24670532", "투세븐자체제작F/W신상슈즈", 34900, 2));
		productMap.put("24669991", new Product("24669991", "가을맞이모던큐트로퍼/플랫", 17900, 9));

		productMap.put("24669702", new Product("24669702", "트루릴리젼프리미엄스니커즈",  37500, 1));
		productMap.put("24667948", new Product("24667948", "나이키남녀팬츠모음전", 49000, 1));
		productMap.put("24664912", new Product("24664912", "축구/농구/배구공모음전", 14000, 6));
		productMap.put("24661322", new Product("24661322", "쿨제이가을신상트랜디셔츠", 19800, 2));
		productMap.put("24660422", new Product("24660422", "도드람포크돼지갈비", 5400, 1));
		productMap.put("24659696", new Product("24659696", "[후쿠오카]자유여행3일189000", 189000, 1));
		productMap.put("24659141", new Product("24659141", "HKCLA다이어트", 29700, 1));
		productMap.put("24654726", new Product("24654726", "[청담]민한복", 350000, 15));
		productMap.put("24654255", new Product("24654255", "[동대문]애니피부", 15000, 4));
		productMap.put("24651025", new Product("24651025", "영진표고버섯슬라이스1kg", 18500, 2));
		
		
	}
	
	/**
	 * 상품번호 일치하는 상품 객체를 반환한다.
	 * @param productId : 상품번호
	 * @return 상품객체
	 */
	public Product getItem(String productId){
		return this.productMap.get(productId);
		
	}
	
	/**
	 * 상품 객체를 저장한다.반환한다.
	 * @param productId : 상품번호
	 * @param item : 상품객체
	 */
	public void setItem(String productId, Product item){
		this.productMap.put(productId,item);
		
	}
	
	/**
	 * 재고량 검증 및 조정(스레드 동기화)
	 * @param produtId : 상품번호
	 * @param purchaseCount
	 * @throws SoldOutException
	 */
	public synchronized void reCalcItemCount(String productId, int purchaseCount) throws SoldOutException{
		int stockCount = 0; //재고수량
		
		Product item = this.getItem(productId);//구입되는 물품
		stockCount = item.getCount() - purchaseCount;
		
		//재고량이 부족한지 검사
		if(stockCount < 0 ){
			throw new SoldOutException("재고량이 부족합니다. 상품명:"+item.getProductName()+" 주문수량:"+purchaseCount);
		}
		//재고량 다시 저장
		item.setCount(stockCount);
		this.setItem(productId, item);
		
	}
	
	public String toString(){
		StringBuffer message = new StringBuffer();
		message.append("상품번호\t\t\t상품명\t\t판매가격\t재고수\n");
		
		Product item = null;
		for(Object key : this.productMap.keySet()){
			item = this.productMap.get(key);
			message.append(item.getProductId()).append("\t")
			       .append(item.getProductName()).append("\t\t")
			       .append(item.getPrice()).append("\t")
			       .append(item.getCount()).append("\n");
			
		}
		return message.toString();
	}

	

}
