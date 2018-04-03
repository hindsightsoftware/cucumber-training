package library;

public class Fibonacci {

    public String getSequence(int count) {
        StringBuilder output = new StringBuilder();
        int[] sequence = new int[count];
        sequence[0] = 0;
        sequence[1] = 1;

        for(int i = 2; i < count; i++){
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }

        for(int i = 0; i < count; i++){
            output.append(sequence[i]);

            if(i < count -1){
                output.append(", ");
            }
        }

        return output.toString();
    }

}
