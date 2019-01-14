package com.lym.pattern.observerDemo;

public interface Subject {
	public void registerOberver(Observer o);
	public void removeObserver(Observer o);
    public void notifyAllObservers();
}
