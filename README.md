# Simple

//query
//查询字段name中包含"张""王"的数据并返回全部
List<User> allUser = ORMLite.newLite().query(User.class).in("name", new String[]{"张", "王"}).findAll();
//查询字段name中包含"张""王"的数据并返回首条数据
User firstUser = ORMLite.newLite().query(User.class).in("name", new String[]{"张", "王"}).findFirst();
//查询用户中money大于1000且年龄在10-20之间的用户
List<User> users = ORMLite.newLite().query(User.class).gt("money", 1000).between("age", 10, 20).findAll();

//update
ORMLite.newLite().update(User.class).gt("age", 20).update();

 //insert
//插入一条数据
User user = new User();
ORMLite.newLite().insert(User.class).one(user).insert();
//插入多条数据
ArrayList<User> inserts = new ArrayList<>();
inserts.add(new User());
inserts.add(new User());
inserts.add(new User());
ORMLite.newLite().insert(User.class).mults(inserts).insert();

//delete
//删除用户名为test1的记录
ORMLite.newLite().delete(User.class).equalTo("name", "test1").delete();
//删除用户名为test1且年龄在30-50之间的记录
ORMLite.newLite().delete(User.class).equalTo("name", "test1").between("age",30,50).delete();
```
# License

    Copyright 2019 ben,liujianguangnice

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
