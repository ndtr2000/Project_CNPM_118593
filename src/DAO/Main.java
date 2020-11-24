package DAO;

import java.util.List;

import Core.Leader;


public class Main {
	public static void main(String args[]) throws Exception {
		LeaderDAO leaderDAO = new LeaderDAO();
		Leader leader = leaderDAO.getLeader();
		System.out.print(leader.toString());
	}
}
