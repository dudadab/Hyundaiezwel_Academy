package alg.datastructure;

public class Run {

    public static void main(String[] args) {
        System.out.println(init());
        testGet();
        testRemove();
    }

    private static void testRemove(){
        ArrayList<Integer> list = init();
        for(int i = 5; i < 8; i++){
            list.remove(i);
        }
        System.out.println(list);
    }

    private static void testGet(){
        ArrayList<Integer> list = init();
        for(int i = 5; i < 8; i++){
            System.out.println(list.get(i));
        }
    }

    private static ArrayList<Integer> init(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 15; i++){
            list.add(i);
        }

        return list;
    }
}
