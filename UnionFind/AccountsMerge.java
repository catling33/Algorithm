package UnionFind;

import java.util.*;

public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // DSU structure
        DSU dsu = new DSU();

        // three hashmaps
        Map<String, Integer> emailToID = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // record ID to use
        int ID = 0;
        // iterate and draw connections
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, ID++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        // iterate through each email accounts, sort into groups
        Map<Integer, List<String>> groupMap = new HashMap();
        for (String email : emailToID.keySet()) {
            int index = dsu.find(emailToID.get(email));
            if (!groupMap.containsKey(index)) {
                groupMap.put(index, new ArrayList<String>());
            }
            List<String> list = groupMap.get(index);
            list.add(email);
        }

        // add groups to result
        for (List<String> list : groupMap.values()) {
            Collections.sort(list);
            list.add(0, emailToName.get(list.get(0)));
        }
        return new ArrayList(groupMap.values());
    }

    // DSU structure
    class DSU {

        int[] parent;
        int[] rank;

        public DSU() {
            rank = new int[10001];
            parent = new int[10001];
            for (int i = 0; i <= 10000; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xr = find(x);
            int yr = find(y);
            if (rank[xr] > rank[yr]) {
                parent[yr] = xr;
            } else if (rank[xr] < rank[yr]) {
                parent[xr] = yr;
            } else {
                parent[yr] = xr;
                rank[xr]++;
            }
        }
    }
}

// method : union find to joint the sets with common email name

// data structure:
// DSU to store parent of all emails, provide union and find method
// hashmap - emailToId : <email, ID in DSU>
// hashmap - emailToName : <email, name>
// hashmap - emailGroups : <ID of root, list of emails> to group emails

// record ID to use
// iterate through accounts
// for each account list, iterate through
// map email to corresponding name
// if the email is not recorded in DSU yet
// assign an ID to email,
// draw connection between this email ID with first email ID in the current set

// iterate through all email addresses
// sort group the emails using find
// store each group in hashmap

// for each groups of emails in the hashmap
// sort the emails
// find the name of first email in each group
// add name and lists of emails to result array list

// TC = O(n) where n = all email and name entries in the list
// SC = O(k) where k = all unique email and name
