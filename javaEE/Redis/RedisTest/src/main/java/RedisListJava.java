import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisListJava {
    public static void main(String[] args) {
        //杩炴帴链湴镄?Redis 链嶅姟
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //瀛桦偍鏁版嵁鍒板垪琛ㄤ腑
        jedis.lpush("tutorial-list", "Redis");
        jedis.lpush("tutorial-list", "Mongodb");
        jedis.lpush("tutorial-list", "Mysql");
        // 銮峰彇瀛桦偍镄勬暟鎹苟杈揿嚭
        List<String> list = jedis.lrange("tutorial-list", 0, 5);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Stored string in redis:: " + list.get(i));
        }
    }
}