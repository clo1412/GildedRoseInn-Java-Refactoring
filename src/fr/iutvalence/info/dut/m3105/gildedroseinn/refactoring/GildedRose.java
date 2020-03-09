package refactoring;

import java.util.*;

public class GildedRose {
	private static final int AVG_SELLIN = 11;
	private static final int MIN_SELLIN = 6;
	private static final int MIN_QUALITY = 50;

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

		System.out.println("OMGHAI!");

		addItems();

		updateAll();
	}

	private static void addItems() {

		items.add(new Item("+5 Dexterity Vest", 10, 20));
		items.add(new Item("Aged Brie", 2, 0));
		items.add(new Item("Elixir of the Mongoose", 5, 7));
		items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		items.add(new Item("Conjured Mana Cake", 3, 6));
	}

	public static void updateAll(){
		for(int i=0; i<items.size(); i++){
			if(items.get(i).getName()!="Sulfuras, Hand of Ragnaros"){
				items.get(i).setSellIn(items.get(i).getSellIn()-1);
			}
			if(items.get(i).getName()=="Aged Brie" || items.get(i).getName()=="Sulfuras, Hand of Ragnaros"){
				updateQualityAgedSulfuras(i);
			}else if(items.get(i).getName()=="Backstage passes to a TAFKAL80ETC concert"){
				updateQualityBackstage(i);
			}else{

			}
		}
	}

	public static void updateQualityAgedSulfuras(int i){
		if(items.get(i).getQuality() < MIN_QUALITY){
			items.get(i).setQuality(items.get(i).getQuality()+1);
			if(items.get(i).getSellIn() < 0){
				items.get(i).setQuality(items.get(i).getQuality()+1);
			}
		}
	}

	public static void updateQualityBackstage(int i){
		if(items.get(i).getQuality() < MIN_QUALITY){
			items.get(i).setQuality(items.get(i).getQuality()+1);
			if(items.get(i).getSellIn() < 0){
				items.get(i).setQuality(items.get(i).getQuality()+1);
			}
		}
		if(items.get(i).getSellIn() < AVG_SELLIN){
			items.get(i).setQuality(items.get(i).getQuality()+1);
		}
		if(items.get(i).getSellIn() < MIN_SELLIN){
			items.get(i).setQuality(items.get(i).getQuality()+1);
		}
	}

	public static void updateOther(int i){
		if(items.get(i).getQuality() > 0){
			items.get(i).setQuality(items.get(i).getQuality()-1);
			if(items.get(i).getSellIn() < 0){
				items.get(i).setQuality(items.get(i).getQuality()-1);
			}else{
				items.get(i).setQuality(0);
			}
		}
	}


}
