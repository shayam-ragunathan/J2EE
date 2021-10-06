package sample.beans;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
	private List<String> contents =new ArrayList<>();

	public List<String> getContents() {
		return contents;
	}

	public void setContents(List<String> contents) {
		this.contents = contents;
	}

}
