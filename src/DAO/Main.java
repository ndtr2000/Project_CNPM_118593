package DAO;

import java.util.List;

import Core.Renter;

public class Main {
	public static void main(String args[]) throws Exception {
		RenterDAO renterDAO = new RenterDAO();
		List<Renter> renterList = renterDAO.getAllRenter();
		System.out.print(renterList.get(0).toString());
	}
}
