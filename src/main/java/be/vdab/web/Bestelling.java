package be.vdab.web;

import java.util.Map;

public interface Bestelling {
	void setBestellijn(long id, int aantal);
	Map<Long,Integer> getBestellijnen();
	void clearBestellijnen();
}
