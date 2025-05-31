package desafio_vaga_99_junior.mapper;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class ObjectMapper {
    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static  <O,D> D parseObject(O origem, Class<D> destino ){
       return mapper.map(origem, destino);
    }

    public static <O,D> List<D> parseListObjects(List<O> origem, Class<D> destino){
        List<D> listObjects = new ArrayList<D>();
        for (Object o : origem){
            listObjects.add(mapper.map(o, destino));
        }
        return listObjects;
    }
}
