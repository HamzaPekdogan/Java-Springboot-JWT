package poliklinik.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import poliklinik.dao.CalisanDAO;
import poliklinik.entity.Calisan;

import static java.util.Collections.emptyList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private CalisanDAO calisanDAO;

    public UserDetailsServiceImpl(CalisanDAO calisanDAO) {
        this.calisanDAO = calisanDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String telNo) throws UsernameNotFoundException {
        Calisan calisan = calisanDAO.findByTelefonNumarasi(telNo);
        if (calisan == null) {
            throw new UsernameNotFoundException(telNo);
        }
        return new User(calisan.getTelefonNumarasi(), calisan.getSifre(), emptyList());
    }
}