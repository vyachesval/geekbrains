package lesson3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        List<Integer> al = new ArrayList<>(550);
//        al.add(1);
//        al.add(2);
//        al.add(3);
//        al.add(4);
//        al.add(5);
//        al.add(2,90);
//        System.out.println(al);
//        System.out.println(al.get(3));
//        ((ArrayList<Integer>) al).ensureCapacit
//        y(300);
//        ((ArrayList<Integer>) al).trimToSize();
//        System.out.println(al.isEmpty());
////        al.clear();
////        System.out.println(al);
//        System.out.println(al.size());
//
//        al.remove((Integer) 2);
//        System.out.println(al);

        List<String> states = new ArrayList<>();
//        states.addAll(Arrays.asList("Германия Германия Франция Россия США".split(" ")));
        states.add("Германия");
        states.add("Германия");
        states.add("Франция");
        states.add("Россия");
        states.add("США");
        System.out.println(states);

//        for (int i = 0; i < states.size(); i++) {
//            if(states.get(i).equals("Германия")){
//                states.remove(i);
//                i--;
//            }
//        }

//        Iterator<String> iterator = states.iterator();
//        while(iterator.hasNext()){
//            if(iterator.next().equals("Германия")){
//                iterator.remove();
//            }
//        }

//        states.removeIf(x -> x.equals("Германия"));
//        states.removeIf(x -> x.length()>4);
//        states.removeIf(x -> x.startsWith("Г"));
        states.removeIf(x -> x.contains("ан"));
        System.out.println(states);


        LinkedList<Integer> ll = new LinkedList<>();
        ll.add(6);
        ll.addLast(56);
        ll.offer(7);
        ll.addFirst(1);
        ll.add(2, 55);
        System.out.println(ll);

//        System.out.println(ll.getFirst());
//        System.out.println(ll.element());
//        System.out.println(ll.peek());

        ListIterator<Integer> listIterator = ll.listIterator();
        listIterator.add(123);
        listIterator.add(133);
        System.out.println(ll);

        listIterator.next();
        listIterator.next();
        listIterator.add(999);
        System.out.println(ll);
        listIterator.previous();
        listIterator.add(888);
        System.out.println(ll);

        while (listIterator.hasNext()) {
            System.out.print(listIterator.next() + " ");
        }
        System.out.println();
        while (listIterator.hasPrevious()) {
            System.out.print(listIterator.previous() + " ");
        }
        System.out.println();

        Queue<Integer> queue = new LinkedList<>(ll);
        System.out.println(queue);
        System.out.println(queue.poll());//remove
        queue.offer(776);//add;
        System.out.println(queue.peek());//element;
        System.out.println(queue);

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(55);
        System.out.println(stack.pop());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(4);
        pq.add(7);
        System.out.println(pq.poll());

        Set<Integer> set = new HashSet<>();
//        Set<Integer> set = new TreeSet<>();
//        Set<Integer> set = new LinkedHashSet<>();

        set.add(123);
        set.add(123);
        set.add(3);
        set.add(13);
        set.add(12);
        set.add(99);

        System.out.println(set);

//        Map<String, Integer> map = new HashMap<>();
//        Map<String, Integer> map = new TreeMap<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("bVaska", 5);
        map.put("bVaska", 9);
        map.put("aMurka", 2);
        map.put("cRisik", 7);
        System.out.println(map);
//        System.out.println(map.get("aMurkfgdfa"));

        Set<Map.Entry<String, Integer>> setM = map.entrySet();
        for (Map.Entry<String, Integer> es : setM) {
            System.out.println(es.getKey());
            System.out.println(es.getValue());
        }

        Random random = new Random();
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < 100; i++) {
            int num = random.nextInt(10);
            Integer currentNum = countMap.get(num);

            if (currentNum == null) {
                currentNum = 1;
            } else {
                currentNum++;
            }
            countMap.put(num, currentNum);

//            countMap.put(num, currentNum == null ? 1 : currentNum + 1);
        }
        System.out.println(countMap);

        int id = 554;
        HashMap<Integer,String> hm = init();
        System.out.println(hm.getOrDefault(id,"Default"));

//        Map<String, ArrayList<String>> mm= new HashMap<>();

    }

    static HashMap<Integer,String> init(){
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(551,"test1");
        hm.put(552,"test2");
        hm.put(553,"test3");
        return hm;
    }
}
