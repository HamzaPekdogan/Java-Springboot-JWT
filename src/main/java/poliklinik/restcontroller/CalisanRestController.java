package poliklinik.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import poliklinik.dao.CalisanDAO;
import poliklinik.entity.Calisan;

import java.util.List;

@RestController
@RequestMapping("/calisan")
public class CalisanRestController {
    private CalisanDAO calisanDAO;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public CalisanRestController(CalisanDAO calisanDAO,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.calisanDAO = calisanDAO;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @RequestMapping(value = "/kaydet", method = RequestMethod.POST)
    public void signUp(@RequestBody Calisan calisan) {
        calisan.setSifre(bCryptPasswordEncoder.encode(calisan.getSifre()));
        calisanDAO.save(calisan);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ResponseEntity<List<Calisan>> findAll() {
        return new ResponseEntity<>(calisanDAO.findAll(),HttpStatus.OK);
    }
}
