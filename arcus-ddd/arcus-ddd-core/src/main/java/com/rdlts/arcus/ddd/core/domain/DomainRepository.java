package com.rdlts.arcus.ddd.core.domain;

import java.util.Collection;
import java.util.Optional;

/**
 * Domain Repository 领域资源库
 * <h1>概述</h1>
 *
 * 资源库的主要作用是提供一个抽象层，它从领域模型的角度出发，用于对聚合根进行访问和持久化。
 * 简而言之，资源库是在领域模型和数据映射层之间的一个中介，使得领域模型可以独立于数据存储逻辑。
 * <br>
 * <br>
 * <b>资源库的主要职责和作用包括</b>
 * <h3>1. 聚合根/实体的持久化</h3>
 * <ul>
 *  <li>资源库管理着聚合根/实体的生命周期，负责将聚合根持久化到数据库中，以及从数据库中恢复聚合根。</li>
 *  <li>它抽象出了数据访问逻辑，使得领域层不需要直接与数据存储细节打交道。</li>
 * </ul>
 * <h3>2. 数据访问的封装</h3>
 * <ul>
 *  <li>资源库提供了一种查询接口，允许领域层以领域特定的方式查询数据，而不是依赖于具体的数据库查询语言或ORM技术。</li>
 *  <li>这使得代码更加清晰、可维护，并且易于更换底层数据库实现。</li>
 * </ul>
 * <h3>3. 领域逻辑与数据存储的分离</h3>
 * <ul>
 *  <li>资源库模式帮助将业务逻辑（领域模型）与数据持久化（如数据库操作）逻辑分离开来。</li>
 *  <li>这种分离使得领域逻辑更加集中，更易于测试和维护。</li>
 * </ul>
 * <h3>4.内存中的集合</h3>
 * <ul>
 *  <li>从概念上讲，资源库就像是一个集合，领域对象可以从中被获取或添加。</li>
 *  <li>这样的抽象使得领域层代码更加自然和直观。</li>
*  </ul>
 * <h3>一致性和事务管理</h3>
 * <ul>
 *  <li>资源库还可以承担确保数据一致性和处理事务的职责。</li>
 *  <li>在复杂的业务操作中，这一点尤为重要。</li>
 * </ul>
 *
 * @param <DE> 聚合根/实体
 * @param <IdentityType> 实体主键类型
 */
public interface DomainRepository<DE extends DomainEntity<IdentityType>, IdentityType> {

    /**
     * 自生成策略 ：返回下一个实体主键对象
     * 如无 则不需要实现该接口
     *
     * @return IdentityType
     */
    default IdentityType nextIdentity() {
        throw new UnsupportedOperationException("nextIdentity not implement!");
    }

    /**
     * 根据实体主键 查找一个实体
     * @param identityType IdentityType
     * @return DE
     */
    Optional<DE> find(IdentityType identityType);

    /**
     * 查找所有仓库实体
     * @return Collection DE
     */
    Collection<DE> findAll();

    /**
     * 保存一个实体
     * @param entity DE
     */
    void save(DE entity);

    /**
     * 批量保存实体
     * @param entityCollection Collection DE
     */
    void saveAll(Collection<DE> entityCollection);

    /**
     * 删除一个实体
     * 是否是物理还是逻辑删除由底层架构实现，领域层不关心。
     * @param entity DE
     */
    void remove(DE entity);

    /**
     * 删除所有实体
     * @param entityCollection Collection DE
     */
    void removeAll(Collection<DE> entityCollection);
}
