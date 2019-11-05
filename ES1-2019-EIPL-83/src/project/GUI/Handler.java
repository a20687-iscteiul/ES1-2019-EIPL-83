package project.GUI;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Handler {

	private ArrayList<Method> methods = new ArrayList<Method>();

	/**
	 * Opens file and generates a Method object for each line
	 */
	public void BuildObjects() {
		try {
			String folderPath = System.getProperty("user.dir");
			String filePath = folderPath + "//src/DataEs1.csv";
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				String[] method = line.split(",");
				vectorToMethod(method);
				line = br.readLine();
			}
			br.close();
			for (Method method : methods) {
				System.out.println(method.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void vectorToMethod(String[] vMethod) {
		int id = Integer.parseInt(vMethod[0]);
		String inPackage = vMethod[1];
		String inClass = vMethod[2];
		String methodName = vMethod[3];
		int LOC = Integer.parseInt(vMethod[4]);
		int CYCLO = Integer.parseInt(vMethod[5]);
		int ATFD = Integer.parseInt(vMethod[6]);
		float LAA = Float.parseFloat(vMethod[7]);
		boolean is_long_method = Boolean.parseBoolean(vMethod[8]);
		boolean iPlasma = Boolean.parseBoolean(vMethod[9]);
		boolean PMD = Boolean.parseBoolean(vMethod[10]);
		boolean is_feature_envy = Boolean.parseBoolean(vMethod[11]);
		Method method = new Method(id, inPackage, inClass, methodName, LOC, CYCLO, ATFD, LAA, is_long_method, iPlasma,
				PMD, is_feature_envy);
		methods.add(method);
	}

	public static void main(String[] args) {
		Handler h = new Handler();
		h.BuildObjects();
	}
}