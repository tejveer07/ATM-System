public class pre {
    public static void main(String[] args) {
        java.util.Random rand = new java.util.Random();

        for(int i=0;i<200;i++)
        System.out.println(rand.nextInt(1000,9999)+""+rand.nextInt(1000,9999)+""+rand.nextInt(1000,9999)+""+rand.nextInt(1000,9999));
    }
}
