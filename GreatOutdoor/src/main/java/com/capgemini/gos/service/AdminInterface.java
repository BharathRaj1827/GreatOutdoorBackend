package com.capgemini.gos.service;

import com.capgemini.gos.entity.Admins;

public interface AdminInterface {
	Admins validate(String aname, String apwd);
}
