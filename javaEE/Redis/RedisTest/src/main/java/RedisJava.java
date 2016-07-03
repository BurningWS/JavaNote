import jdk.nashorn.internal.scripts.JD;
import redis.clients.jedis.Jedis;

public class RedisJava {
    public static void main(String[] args) {
        //杩炴帴链湴镄?Redis 链嶅姟
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //镆ョ湅链嶅姟鏄惁杩愯
        System.out.println("Server is running: " + jedis.ping());
        System.out.println(jedis.keys("*"));
    }
}