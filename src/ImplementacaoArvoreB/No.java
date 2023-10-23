package ImplementacaoArvoreB;

import java.util.Arrays;

public class No {
private static final int ordem = 4;

        int numChaves = 0;
        int chaves[] = new int[2*ordem-1];
        No filhos[] = new No[2*ordem];
        boolean folha = true;

        public No() {
            for(int i = 0; i < 2*ordem; i++) {
                filhos[i] = null;
            }
        }

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("No [numChaves=");
			builder.append(numChaves);
			builder.append(", chaves=");
			builder.append(Arrays.toString(chaves));
			builder.append(", filhos=");
			builder.append(Arrays.toString(filhos));
			builder.append(", folha=");
			builder.append(folha);
			builder.append(", getClass()=");
			builder.append(getClass());
			builder.append(", hashCode()=");
			builder.append(hashCode());
			builder.append(", toString()=");
			builder.append(super.toString());
			builder.append("]");
			return builder.toString();
		}    
        
        
}       