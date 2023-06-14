package com.masai.dao;

import com.masai.entity.*;

public interface CSRDao {
	
	void saveCSR(CSR csr);
	void updateCSR(CSR csr);
	void deleteCSR(String csrId);
	CSR getCSRById(String csrId);

}
