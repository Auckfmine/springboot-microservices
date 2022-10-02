package com.microservices.repositories;

import com.microservices.entities.Reglement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IReglementRepository extends JpaRepository<Reglement,Long> {
   List<Reglement> findByIdFacture(Long idFacture);

   @Query("SELECT sum(r.montantPaye) FROM Reglement r where  r.dateReglement between :startDate"
           + " and :endDate")
   float getChiffreAffaireEntreDeuxDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
