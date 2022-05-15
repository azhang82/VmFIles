import java.util.*;
public class Lesson10 {
	public static void main(String[] args) {
		int[] array = {4, 6, 1, 3, 8};
		Pair <Integer, Integer>p = getMinMax(array);
		System.out.println(p.left + "" +  p.right); // 1 8
		int min = (Integer)p.left;
		int max = (Integer)p.right;
		
		String[] ballots = {"Alex", "Alice", "James", "Michael", "Bryce", "James"};
		Pair<String, Integer> winner = getWinner(ballots);
		String winnerCandidate = winner.left;
		int winnerVotes = winner.right;
		System.out.println(winnerCandidate + ":" + winnerVotes);
		
		List<String> ballotsList = toList(ballots);
		System.out.println(ballotsList);
	}
	
	static  <T> List<T> toList(T[] array) {
			List<T> list = new ArrayList<>();
			for(T value : array) {
				list.add(value);
			}
			return list;
	}
	// motivation: Java functions can only return 1 output (at most)
	
	static class Pair<L, R> {
		L left;
		R right;
		
		Pair(L l, R r) {
			left = l;
			right = r;
		}
	}
	// returns a Pair containing the winner candidate and their number of votes
	static Pair<String, Integer> getWinner(String[] ballots) {
		Map<String, Integer> tally = new TreeMap<>();
		
		for(String candidate : ballots) {
			if(tally .containsKey(candidate)) {
				tally.put(candidate, tally.get(candidate) + 1);
			} else {
				tally.put(candidate,  1);
			}
		}
		String winner = null;
		int winnerVotes = 0;
		for(String candidate : tally.keySet()) {
			int votes = tally.get(candidate);
			if(votes > winnerVotes) {
				winner = candidate;
				winnerVotes = votes;
			}
		}
		
		return new Pair<>(winner, winnerVotes);
	}
	static Pair<Integer, Integer> getMinMax(int[] array) {
		int min = array[0], max = array[0];
		for(int x : array) {
			min = Math.min(min,  x);
			max = Math.max(max,  x);
		}
		
		return new Pair<>(min, max); // Integer
	}
	//MyList
	// toy class that resembles ArrayList
	
	
}
