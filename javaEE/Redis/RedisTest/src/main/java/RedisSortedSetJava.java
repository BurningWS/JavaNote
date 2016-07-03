import redis.clients.jedis.Jedis;

import java.util.Set;

public class RedisSortedSetJava {
    public static void main(String[] args) {
        //杩炴帴链湴镄?Redis 链嶅姟
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //瀛桦偍鏁版嵁鍒板垪琛ㄤ腑
        jedis.zadd("as", 3, "a");
        jedis.zadd("as", 4, "b");
        jedis.zadd("as", 5, "c");
        jedis.zadd("as", 1, "d");
        // 銮峰彇瀛桦偍镄勬暟鎹苟杈揿嚭
        Set<String> list = jedis.zrange("as", 0, 10);
        System.out.println(jedis.zrevrange("as",0,-1));;
        System.out.println("Stored string in redis:: " + list);
    }
}