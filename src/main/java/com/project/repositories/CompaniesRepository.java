package com.project.repositories;
import com.project.models.EmpresaModel;

<<<<<<< HEAD:src/main/java/com/project/repositories/CompaniesRepository.java
import com.project.models.EmpresaModel;
=======
>>>>>>> 97c7c4b2c6def47e6b8fc015b673687d80ead0b6:src/main/java/com/project/repositories/EmpresaRepository.java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer> {
    
}