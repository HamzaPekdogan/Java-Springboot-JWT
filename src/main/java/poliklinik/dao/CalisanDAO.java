package poliklinik.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import poliklinik.entity.Calisan;

public interface CalisanDAO extends JpaRepository<Calisan, Long>{
    Calisan findByTelefonNumarasi(String telNo);
}
