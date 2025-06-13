package com.sysman.demo.common;

import org.springframework.web.context.request.NativeWebRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sysman.demo.entity.CityDB;
import com.sysman.demo.entity.CountiesDB;
import com.sysman.demo.entity.MaterialDB;
import com.sysman.demo.model.APIMessage;
import com.sysman.demo.model.APIResponses;
import com.sysman.demo.model.APIResponsesDataInner;
import com.sysman.demo.model.City;
import com.sysman.demo.model.Counties;
import com.sysman.demo.model.Material;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ApiUtil {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ApiUtil.class);

    public static void setExampleResponse(NativeWebRequest req, String contentType, String example) {
        try {
            HttpServletResponse res = req.getNativeResponse(HttpServletResponse.class);
            res.setCharacterEncoding("UTF-8");
            res.addHeader("Content-Type", contentType);
            res.getWriter().print(example);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @param parameter
     * @param message
     * @return List<APIResponsesDataInner>
     */
    public static List<APIResponsesDataInner> toApiMessage(String parameter, String message) {
        List<APIMessage> listApiMessage = new ArrayList<APIMessage>();
        listApiMessage.add(new APIMessage(parameter, message));
        return listApiMessage.stream().collect(Collectors.toList());
    }

    /**
     * @param apiError ProductErrorLogs
     * @return APIResponses
     */
    public static APIResponses toApiResponse(MaterialErrorLogs mel) {
        return new APIResponses(mel.getCode(), mel.getStatus(), mel.getExecuted(),
                toApiMessage(mel.getField(), mel.getMessage()), mel.getUri(),
                mel.getProcess());
    }

    /**
     * @param code        String
     * @param status      String
     * @param whereCaught String
     * @param parameter   String
     * @param message     String
     * @return ProductErrorLogs
     */
    public static MaterialErrorLogs toProductErrorLogs(String code, String status, String whereCaught, String parameter,
            String message) {
        return new MaterialErrorLogs(code, status, LocalDateTime.now().toString(), whereCaught, parameter, message,
                "/product", UUID.randomUUID().toString());
    }

    /**
     * @param object
     */
    public static void toLogger(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(object);
            log.error(jsonString);
        } catch (Exception e) {
            log.error(
                    "Ocurrio un error en metodo toLogger al convertir objeto en json en clase ApiUtil, el error es: "
                            + e.getMessage());
        }
    }

    /**
     * @param producto
     * @return List<APIResponsesDataInner>
     */
    public static List<APIResponsesDataInner> toMaterial(MaterialDB mDB, City c) {
        Material m = new Material();

        m.setCity(c);

        m.setName(mDB.getName());
        m.setDescription(mDB.getDescription());
        m.setType(mDB.getType());
        m.setPurchaseAt(Date.from(mDB.getPurchaseAt().atZone(ZoneId.systemDefault()).toInstant()));
        m.setSaleAt(Date.from(mDB.getSaleAt().atZone(ZoneId.systemDefault()).toInstant()));
        m.setStatus(mDB.getStatus());

        ArrayList<Material> miLista = new ArrayList<>();
        miLista.add(m);

        return miLista.stream().collect(Collectors.toList());
    }

    /**
     * @param lCiDB List<CityDB> 
     * @param lCo List<Counties>
     * @return List<City>
     */
    public static List<City> toCity(List<CityDB> lCiDB,List<Counties> lCo) {
        return lCiDB.stream().map(ciDB -> {
            return new City(lCo.get(0), ciDB.getCode(),ciDB.getName());
        }).collect(Collectors.toList());
    }

    /**
     * @param lCoDB List<CountiesDB>
     * @return List<Counties>
     */
    public static List<Counties> toCounties(List<CountiesDB> lCoDB) {
        return lCoDB.stream().map(coDB -> {
            return new Counties(coDB.getCode(),coDB.getName());
        }).collect(Collectors.toList());
    }
   

    /**
     * @param lMDB List<MaterialDB>
     * @param lCi List<City>
     * @return List<APIResponsesDataInner>
     */
    public static List<APIResponsesDataInner> toMaterial(List<MaterialDB> lMDB, List<City> lCi) {
        return lMDB.stream().map(mDB -> {
            return new Material(lCi.get(0), mDB.getName(),mDB.getDescription(),mDB.getType(),Date.from(mDB.getPurchaseAt().atZone(ZoneId.systemDefault()).toInstant()),Date.from(mDB.getSaleAt().atZone(ZoneId.systemDefault()).toInstant()),mDB.getStatus());
        }).collect(Collectors.toList());
    }
}
