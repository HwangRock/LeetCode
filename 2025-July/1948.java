import java.util.*;

class Solution {

    static class TrieNode {
        Map<String, TrieNode> children = new HashMap<>();
        boolean isDeleted = false;
    }

    TrieNode root = new TrieNode();
    Map<String, List<TrieNode>> seen = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        for (List<String> path : paths) {
            TrieNode curr = root;
            for (String folder : path) {
                curr = curr.children.computeIfAbsent(folder, k -> new TrieNode());
            }
        }

        serialize(root);

        for (List<TrieNode> nodeList : seen.values()) {
            if (nodeList.size() > 1) {
                for (TrieNode node : nodeList) {
                    node.isDeleted = true;
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        
        return result;
    }

    private String serialize(TrieNode node) {
        if (node.children.isEmpty()) return "";

        List<String> parts = new ArrayList<>();
        for (String key : new TreeSet<>(node.children.keySet())) {
            String sub = serialize(node.children.get(key));
            parts.add(key + "(" + sub + ")");
        }

        String serial = String.join("", parts);
        seen.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }

    private void dfs(TrieNode node, List<String> path, List<List<String>> result) {
        for (Map.Entry<String, TrieNode> entry : node.children.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();

            if (child.isDeleted) continue;

            path.add(folder);
            result.add(new ArrayList<>(path));
            dfs(child, path, result);
            path.remove(path.size() - 1);
        }
    }
}
