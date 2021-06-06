package com.realestate.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.realestate.dao.AdminDao;
import com.realestate.entity.Admin;

@Service
public class AdminService {
	@Autowired
	private AdminDao adminDao;
	public Optional<Admin> getAdmin(int id) {
		Optional<Admin> admin=null;
		try {
			admin=this.adminDao.findById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return admin;
	}
	public List<Admin> getAllAdmins(){
		return this.adminDao.findAll();
	}
	public Admin setAdmin(Admin a) {
		return this.adminDao.save(a);
	}
	public void deleteAdmin(int id){
		this.adminDao.deleteById(id);
	}
	public void updateAdmin(Admin a,int id) {
		Optional<Admin> optional=this.adminDao.findById(id);
		Admin admin=optional.get();
		admin.setAdminName(null);
		admin.setAdminEmail(null);
		admin.setAdminPassword(null);
		admin.setAdminCity(null);
		admin.setAdminState(null);
	}
}
