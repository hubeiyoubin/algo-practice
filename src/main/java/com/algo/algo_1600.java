package com.algo;

import java.util.*;

/**
 * @author yb
 * @date: 2021-1-22
 * 1600 皇位继承顺序
 */
public class algo_1600 {
    class ThroneInheritance {

        HashMap<String, ArrayList<String>> hashMap=new HashMap<>();//父节点-孩子节点链表
        /**用哈希表表示多叉树*/
        Set<String> set_dead =new HashSet<>();
        String kingname;
        public ThroneInheritance(String kingName) {
            this.kingname = kingName;
            hashMap.put(kingName, new ArrayList<>());
        }

        public void birth(String parentName, String childName) {
            if(hashMap.containsKey(parentName)){
                hashMap.get(parentName).add(childName);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(childName);
                hashMap.put(parentName,list);
            }
        }

        public void death(String name) {
            set_dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            ArrayList<String> res=new ArrayList<>();
            if(!set_dead.contains(kingname))
                res.add(kingname);
            dfs(kingname,res);
            return res;
        }

        private void dfs(String parentName,ArrayList<String> res){
            if(!hashMap.containsKey(parentName))
                return;
            ArrayList<String> childs=hashMap.get(parentName);
            for (String c:childs) {
                if(!set_dead.contains(c))
                    res.add(c);
                dfs(c,res);
            }
        }
    }

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
}
