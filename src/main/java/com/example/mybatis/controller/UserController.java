package com.example.mybatis.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis.domain.UserInfoDomain;
import com.example.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping(value = "/userInfo")
public class UserController {

    @Autowired
    private UserService userInfoService;

    @RequestMapping("/a")
    public List<UserInfoDomain> getA(){
        List<UserInfoDomain> a = userInfoService.getA();
        return a;
    }

    /**
     * 根据ID获取用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:34
     * @Param  userId  用户ID
     * @Return UserInfoDomain 用户实体
     */
    @RequestMapping("/getInfo")
    public UserInfoDomain getInfo(String userId){
        UserInfoDomain userInfoDomain = userInfoService.getById(userId);
        return userInfoDomain;
    }

    /**
     * 查询全部信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:35
     * @Param  userId  用户ID
     * @Return List<UserInfoDomain> 用户实体集合
     */
    @RequestMapping("/getList")
    public List<UserInfoDomain> getList(){
        List<UserInfoDomain> userInfoEntityList = userInfoService.list();
        return userInfoEntityList;
    }
    /**
     * 分页查询全部数据
     * @Author Sans
     * @CreateTime 2019/6/8 16:37
     * @Return IPage<UserInfoDomain> 分页数据
     */
    @RequestMapping("/getInfoListPage")
    public IPage<UserInfoDomain> getInfoListPage(){
        //需要在Config配置类中配置分页插件
        IPage<UserInfoDomain> page = new Page<>();
        page.setCurrent(1); //当前页
        page.setSize(5);    //每页条数
        page = userInfoService.page(page);
        return page;
    }
    /**
     * 根据指定字段查询用户信息集合
     * @Author Sans
     * @CreateTime 2019/6/8 16:39
     * @Return Collection<UserInfoDomain> 用户实体集合
     */
    @RequestMapping("/getListMap")
    public Collection<UserInfoDomain> getListMap(){
        Map<String,Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("age",20);
        Collection<UserInfoDomain> userInfoEntityList = userInfoService.listByMap(map);
        return userInfoEntityList;
    }
    /**
     * 新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:40
     */
    @RequestMapping("/saveInfo")
    public void saveInfo(){
        UserInfoDomain UserInfoDomain = new UserInfoDomain();
        UserInfoDomain.setName("小龙");
        UserInfoDomain.setSkill("JAVA");
        UserInfoDomain.setAge(18);
        UserInfoDomain.setFraction(59L);
        UserInfoDomain.setEvaluate("该学生是一个在改BUG的码农");
        userInfoService.save(UserInfoDomain);
    }
    /**
     * 批量新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:42
     */
    @RequestMapping("/saveInfoList")
    public void saveInfoList(){
        //创建对象
        UserInfoDomain sans = new UserInfoDomain();
        sans.setName("Sans");
        sans.setSkill("睡觉");
        sans.setAge(18);
        sans.setFraction(60L);
        sans.setEvaluate("Sans是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子");
        UserInfoDomain papyrus = new UserInfoDomain();
        papyrus.setName("papyrus");
        papyrus.setSkill("JAVA");
        papyrus.setAge(18);
        papyrus.setFraction(58L);
        papyrus.setEvaluate("Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子");
        //批量保存
        List<UserInfoDomain> list =new ArrayList<>();
        list.add(sans);
        list.add(papyrus);
        userInfoService.saveBatch(list);
    }
    /**
     * 更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:47
     */
    @RequestMapping("/updateInfo")
    public void updateInfo(){
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        UserInfoDomain UserInfoDomain = new UserInfoDomain();
        UserInfoDomain.setId(1L);
        UserInfoDomain.setAge(19);
        userInfoService.updateById(UserInfoDomain);
    }
    /**
     * 新增或者更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:50
     */
    @RequestMapping("/saveOrUpdateInfo")
    public void saveOrUpdate(){
        //传入的实体类userInfoEntity中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        UserInfoDomain UserInfoDomain = new UserInfoDomain();
        UserInfoDomain.setId(1L);
        UserInfoDomain.setAge(20);
        userInfoService.saveOrUpdate(UserInfoDomain);
    }
    /**
     * 根据ID删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:52
     */
    @RequestMapping("/deleteInfo")
    public void deleteInfo(String userId){
        userInfoService.removeById(userId);
    }
    /**
     * 根据ID批量删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:55
     */
    @RequestMapping("/deleteInfoList")
    public void deleteInfoList(){
        List<String> userIdlist = new ArrayList<>();
        userIdlist.add("12");
        userIdlist.add("13");
        userInfoService.removeByIds(userIdlist);
    }
    /**
     * 根据指定字段删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:57
     */
    @RequestMapping("/deleteInfoMap")
    public void deleteInfoMap(){
        //kay是字段名 value是字段值
        Map<String,Object> map = new HashMap<>();
        map.put("skill","删除");
        map.put("fraction",10L);
        userInfoService.removeByMap(map);
    }
}
