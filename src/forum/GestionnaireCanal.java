package forum;

import java.util.HashMap;

public class GestionnaireCanal {

	private static HashMap<String, Canal> canal = new HashMap<String, Canal>();
	private static HashMap<String, CanalDeBreve> canalDeBreve = new HashMap<String, CanalDeBreve>();

	public void CreerCanal(String nomCanal, int maxMessage) {
		canal.put(nomCanal, new Canal(nomCanal, maxMessage));
	}
	
	public void CreerCanalDeBreve(String nomCanal, int tailleBreves) {
		canalDeBreve.put(nomCanal, new CanalDeBreve(nomCanal, tailleBreves));
	}
	
	
	public static boolean doesExist(String nomCanal) {
		if (canal.containsKey(nomCanal)) {
			return true;
		}
		return false;
	}
	
}