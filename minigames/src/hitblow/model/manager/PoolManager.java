package hitblow.model.manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PoolManager {
	/**
	 * 720通りの数値リストを返します。
	 * @return pool - List
	 */
	public static List<Integer> gen(){
		List<Integer> tmp = new ArrayList<Integer>();
		for (int x = 0; x <= 9; x++) {
			for (int y = 0; y <= 9; y++) {
				if (x == y) {
					continue;
				}
				for (int z = 0; z <= 9; z++) {
					if (x == z || y == z) {
						continue;
					}
					tmp.add((x * 100) + (y * 10) + z);
				}
			}
		}
		return tmp;
	}
	
	/**
	 * 渡されたリストからランダムに値を取り出します。
	 * @param pool - List
	 * @return randomNum - int
	 */
	public static int getRandomNum(List<Integer> pool) {
		return pool.get(new Random().nextInt(pool.size()));
	}
}
