package graphs;

import java.util.*;

/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0]
is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common
email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people
could have the same name. A person can have any number of accounts initially, but all of their accounts definitely
have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name,
and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"]
,["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],
["John","johnnybravo@mail.com"]]
Explanation:
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [
['Mary', 'mary@mail.com'],
['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
* */
public class AccountsMerge {
    int[] parents = new int[11000];
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();

        for (int i = 0; i < parents.length; i++)
            parents[i] = i;

        int idx = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, idx++);
                }
                // Merge emails - First email in account with current
                union(emailToId.get(account.get(1)), emailToId.get(email));
            }
        }

        // After merging emails collect them with associated id
        Map<Integer, List<String>> mergedEmails = new HashMap<>();
        for (String email : emailToName.keySet()) {
            int index = find(emailToId.get(email));
            if (mergedEmails.containsKey(index)) {
                mergedEmails.get(index).add(email);
            } else {
                List<String> list = new ArrayList<>(Arrays.asList(email));
                mergedEmails.put(index, list);
            }
        }
        // Add name to these merged emails
        for (List<String> mergedValues : mergedEmails.values()) {
            Collections.sort(mergedValues);
            mergedValues.add(0, emailToName.get(mergedValues.get(0)));
        }

        return new ArrayList(mergedEmails.values());
    }

    public void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parents[root2] = root1;
    }

    public int find(int node) {
        if (parents[node] == node) return node;
        return find(parents[node]);
    }
}
