package emlakburada.service;

import emlakburada.model.dto.Advert;
import emlakburada.model.dto.EmailMessage;
import emlakburada.model.dto.RealEstate;
import emlakburada.model.dto.User;
import emlakburada.model.request.AdvertRequest;
import emlakburada.model.request.client.BannerRequest;
import emlakburada.model.response.AdvertResponse;
import emlakburada.repository.AdvertRepository;
import emlakburada.repository.DatabaseRepository;
import emlakburada.service.client.BannerClientFeign;
import emlakburada.service.client.BannerClientRestTemplate;
import emlakburada.service.queue.QueueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdvertService {

    @Autowired
    private AdvertRepository advertRepository;

    @Autowired
    @Qualifier(value = "jdbcRepository")
    private DatabaseRepository dbConn;

    @Autowired
    private UserService userService;

    private static int advertNo = 38164784;

    @Autowired
    private BannerClientRestTemplate bannerClientRestTemplate;

    @Autowired
    private BannerClientFeign bannerClientFeign;

    @Autowired
    private QueueService queueService;

    // @Autowired
//	public IlanService(IlanRepository ilanRepository) {
//		super();
//		this.ilanRepository = ilanRepository;
//	}

    public List<AdvertResponse> getAllAdverts() {
        // System.out.println("IlanService -> ilanRepository: " +
        // advertRepository.toString());
        // kullaniciService.getAllKullanici();
        List<AdvertResponse> advertList = new ArrayList<>();
        for (Advert advert : advertRepository.fetchAllAdverts()) {
            advertList.add(convertToAdvertResponse(advert));
        }
        return advertList;
    }

    public AdvertResponse saveAdvert(AdvertRequest request) {
        Advert savedAdvert = advertRepository.saveAdvert(convertToAdvert(request));
        EmailMessage emailMessage = new EmailMessage("tugbayavuz@gmail.com");
        queueService.sendMessage(emailMessage);

        BannerRequest bannerRequest = new BannerRequest();
        bannerRequest.setAdvertNo(savedAdvert.getAdvertNo());
        bannerClientFeign.saveBanner(bannerRequest);
        return convertToAdvertResponse(savedAdvert);
    }

    private AdvertResponse convertToAdvertResponse(Advert savedAdvert) {
        AdvertResponse response = new AdvertResponse();
        response.setBaslik(savedAdvert.getBaslik());
        response.setFiyat(savedAdvert.getFiyat());
        response.setAdvertNo(savedAdvert.getAdvertNo());
        return response;
    }

    private Advert convertToAdvert(AdvertRequest request) {
        Advert advert = new Advert(new RealEstate(), new User(), new String[5]);
        advertNo++;

        advert.setAdvertNo(advertNo);
        advert.setBaslik(request.getBaslik());
        advert.setFiyat(request.getFiyat());
        return advert;
    }

    public AdvertResponse getAdvertByAdvertId(int advertId) {
        Advert advert = advertRepository.findAdvertByAdvertId(advertId);
        return convertToAdvertResponse(advert);
    }

}
