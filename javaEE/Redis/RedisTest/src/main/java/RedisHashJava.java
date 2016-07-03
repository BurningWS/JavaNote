import redis.clients.jedis.Jedis;

import java.util.Map;
import java.util.Set;

public class RedisHashJava {
    public static void main(String[] args) {
        //杩炴帴链湴镄?Redis 链嶅姟
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //瀛桦偍鏁版嵁鍒板垪琛ㄤ腑
        jedis.hset("ae","name","ws");
        jedis.hset("ae","age","21");
        Map<String, String> ae = jedis.hgetAll("ae");
        // 銮峰彇瀛桦偍镄勬暟鎹苟杈揿嚭
        System.out.println(ae);
    }
}