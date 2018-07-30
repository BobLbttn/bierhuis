package be.vdab.web;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class DefaultBestelling implements Serializable, Bestelling {
	private static final long serialVersionUID = 1L;

	private Map<Long,Integer> mijnBestelling;

	DefaultBestelling (){
		mijnBestelling = new LinkedHashMap <>();
	}

	@Override
	public void setBestellijn(long id, int aantal) {
		mijnBestelling.put(id, aantal);

	}

	@Override
	public Map<Long, Integer> getBestellijnen() {
		return mijnBestelling;
	}

	@Override
	public void clearBestellijnen() {
		mijnBestelling.clear();
	}
	
	@Override
	public int aantalBestellijnen() {
		return mijnBestelling.size();
	}
	
}
