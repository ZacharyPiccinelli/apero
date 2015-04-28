package com.zrp.apero;

public class HealthPotion implements Item {

	private static final int MAX_COUNT = 2;
	private static final String ITEM_NAME = "Health Potion";
	private int count = 0;
	
	@Override
	public String getName() {
		return ITEM_NAME;
	}

	@Override
	public int getCount() {
		return count;
	}

	@Override
	public int getMaxCount() {
		return MAX_COUNT;
	}

	@Override
	public boolean isUseable() {
		return true;
	}

}
