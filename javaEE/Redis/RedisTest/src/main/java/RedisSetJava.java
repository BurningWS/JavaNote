import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class RedisSetJava {
    public static void main(String[] args) {
        //杩炴帴链湴镄?Redis 链嶅姟
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //瀛桦偍鏁版嵁鍒板垪琛ㄤ腑
        jedis.sadd("ad", "5");
        jedis.sadd("ad", "1");
        jedis.sadd("ad", "2");
        jedis.sadd("ad", "3");
        jedis.sadd("ad", "4");
        jedis.sadd("ad", "5");
        jedis.sadd("ad", "3");
        jedis.sadd("ad", "4");
        jedis.sadd("ad", "5");
        // 銮峰彇瀛桦偍镄勬暟鎹苟杈揿嚭
        Set<String> list = jedis.smembers("ad");
        System.out.println("Stored string in redis:: " + list);
    }
}