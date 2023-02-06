package prPracticaThreads3;

public class VariableCompartida extends Object {
		
		private int v;
		
		public VariableCompartida(int v) {
			this.v = v;
		}
		
		public void setV(int v) {
			this.v = v;
		}
		
		public int getV() {
			return this.v;
		}
		
		public void inc(int inc) {
			this.v++;
		}

	}
