import java.io.Serializable;

public class Data implements Serializable {

	private static final long serialVersionUID = 1L;

	static String spotsxml = "";

	public Data() {

		spotsxml = " <spot>"
				+ "<name>Boarder line</name>"
				+ "<info>the best place to buy quality imported boards</info>"
				+ "<lat>32.164</lat>"
				+ "<lon>34.824</lon>"
				+ "<idnumber>0</idnumber>"
				+ "<photourl>http://albums.timg.co.il/userFolders/151/2256062/22560622007331222547.jpg?time=0</photourl>"
				+ "</spot>"
				+ " <spot>"
				+ "<name>Musa</name>"
				+ "<info>the best place to buy quality israely made boards</info>"
				+ "<lat>32.179</lat>" + "<lon>34.80</lon>"
				+ "<idnumber>1</idnumber>" + "</spot>";

	}
}
