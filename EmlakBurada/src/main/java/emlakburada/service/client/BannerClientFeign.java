package emlakburada.service.client;

import emlakburada.model.request.client.BannerRequest;
import emlakburada.model.response.client.BannerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "banner-client", url = "http://localhost/8081")
public interface BannerClientFeign {

    @GetMapping(value = "/banners")
    List<BannerResponse> getAllBanners();

    @PostMapping(value = "/banners")
    BannerResponse saveBanner(@RequestBody BannerRequest request);
}
