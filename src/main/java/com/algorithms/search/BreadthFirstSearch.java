package com.algorithms.search;

import java.util.*;

/**
 * Implemented breadth first search
 * Using to find out path/sortest path with graph
 */
public class BreadthFirstSearch {

    public class Friend{
        String name;
        List<Friend> friendsList;

        public Friend (String name, List<Friend> friendsList){
            this.name = name;
            this.friendsList = friendsList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Friend> getFriendsList() {
            return friendsList;
        }

        public void setFriendsList(List<Friend> friendsList) {
            this.friendsList = friendsList;
        }

    }

    public Optional<Friend> retrieveMyFirstFriendWithSortName (List<Friend> myfriends){
        Queue<Friend>  friendsQueue =  new LinkedList<>(myfriends);
        Set<Friend> friendVisited = new HashSet<>(); //It is a graph could exists circular references
        while(!friendsQueue.isEmpty()) {
            Friend friend = friendsQueue.remove();
            if (friendVisited.add(friend)) {
                if (sortName(friend.getName())) {
                    return Optional.of(friend);
                } else {
                    friendsQueue.addAll(friend.friendsList);
                }
            }
        }
        return Optional.empty();
    }

    private boolean sortName(String name){
        return (name != null && !name.isEmpty() && name.length() < 4);
    }

}
