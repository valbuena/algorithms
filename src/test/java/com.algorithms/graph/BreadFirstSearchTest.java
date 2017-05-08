package graph;


import com.algorithms.graph.BreadthFirstSearch;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class BreadFirstSearchTest {

    BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();

    @Test
    public void test_FirstFriendWithSortName_NoFound (){
        List<BreadthFirstSearch.Friend> myFriends = createListFriends(new String[] {"alice", "boby", "claire"});
        Optional<BreadthFirstSearch.Friend> myFriend = breadthFirstSearch.retrieveMyFirstFriendWithSortName(myFriends);
        Assert.assertFalse(myFriend.isPresent());
    }

    @Test
    public void test_FirstFriendWithSortName_WithoutFriends (){
        Optional<BreadthFirstSearch.Friend> myFriend = breadthFirstSearch.retrieveMyFirstFriendWithSortName(Collections.EMPTY_LIST);
        Assert.assertFalse(myFriend.isPresent());
    }





    @Test
    public void test_FirstFriendWithSortName_Sucessfull (){
        List<BreadthFirstSearch.Friend> myFriends = createListFriends(new String[] {"alice", "bob", "claire"});
        Optional<BreadthFirstSearch.Friend> myFriend = breadthFirstSearch.retrieveMyFirstFriendWithSortName(myFriends);
        Assert.assertTrue(myFriend.isPresent());
        Assert.assertEquals("bob", myFriend.get().getName());
    }

    @Test
    public void test_FirstFriendWithSortName_FirstLevel (){
        List<BreadthFirstSearch.Friend> claireFriends = createListFriends(new String[] {"tom", "mark"});
        BreadthFirstSearch.Friend claire = createFriendWithFriends("claire", claireFriends);
        List<BreadthFirstSearch.Friend> myFriends = new ArrayList<>();
        myFriends.add(createFriendWithoutFriends("alice"));
        myFriends.add(claire);
        myFriends.add(createFriendWithoutFriends("bob"));

        Optional<BreadthFirstSearch.Friend> myFriend = breadthFirstSearch.retrieveMyFirstFriendWithSortName(myFriends);
        Assert.assertTrue(myFriend.isPresent());
        Assert.assertEquals("bob", myFriend.get().getName());
    }

    @Test
    public void test_FirstFriendWithSortName_SecondLevel (){
        List<BreadthFirstSearch.Friend> claireFriends = createListFriends(new String[] {"tom","alex", "mark"});
        BreadthFirstSearch.Friend claire = createFriendWithFriends("claire", claireFriends);
        List<BreadthFirstSearch.Friend> myFriends = new ArrayList<>();
        myFriends.add(createFriendWithoutFriends("alice"));
        myFriends.add(claire);

        Optional<BreadthFirstSearch.Friend> myFriend = breadthFirstSearch.retrieveMyFirstFriendWithSortName(myFriends);
        Assert.assertTrue(myFriend.isPresent());
        Assert.assertEquals("tom", myFriend.get().getName());
    }

    private BreadthFirstSearch.Friend createFriendWithoutFriends(final String name){
        return breadthFirstSearch.new Friend(name, Collections.EMPTY_LIST);
    }

    private BreadthFirstSearch.Friend createFriendWithFriends(final String name, List<BreadthFirstSearch.Friend> friendList){
        return breadthFirstSearch.new Friend(name, friendList);
    }
    private List<BreadthFirstSearch.Friend> createListFriends (final String[] names){
        return Arrays.stream(names)
                .map(name -> createFriendWithoutFriends(name))
                .collect(Collectors.toList());
    }
}
