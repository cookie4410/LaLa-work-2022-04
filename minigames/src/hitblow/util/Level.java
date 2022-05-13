package hitblow.util;

import hitblow.model.AI.EasyAI;
import hitblow.model.AI.ExpertAI;
import hitblow.model.AI.HardAI;
import hitblow.model.AI.NormalAI;
import hitblow.model.bean.ComBean;
import hitblow.model.bean.GameDataBean;

public enum Level {
	EASY {
		public int runAI(ComBean com, GameDataBean gData) {
			return EasyAI.execute(com, gData);
		}
	},
	NORMAL {
		public int runAI(ComBean com, GameDataBean gData) {
			return NormalAI.execute(com, gData);
		}
	},
	HARD {
		public int runAI(ComBean com, GameDataBean gData) {
			return HardAI.execute(com, gData);
		}
	},
	EXPERT {
		public int runAI(ComBean com, GameDataBean gData) {
			return ExpertAI.execute(com, gData);
		}
	},
	SOLO {
		public int runAI(ComBean com, GameDataBean gData) {
			return 0;
		}
	};
	
	public abstract int runAI(ComBean com, GameDataBean gData);
}
