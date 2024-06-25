package bit.turing.screenmatch.interfaces;

public interface ConvertDataInterface {

    <T> T getData(String json, Class<T> classe);

}
