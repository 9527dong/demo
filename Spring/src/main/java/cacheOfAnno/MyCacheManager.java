package cacheOfAnno;

import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

public class MyCacheManager extends AbstractCacheManager {
    private Collection<? extends MyCache> caches;

    /**
     * Specify the collection of Cache instances to use for this CacheManager.
     */
    public void setCaches(Collection<? extends MyCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends MyCache> loadCaches() {
        return this.caches;
    }

}
