package com.uniyaz.core.service;

import com.uniyaz.core.dao.AnketDao;
import com.uniyaz.core.dao.PanelDao;
import com.uniyaz.core.domain.Anket;
import com.uniyaz.core.domain.Panel;

import java.util.List;

public class PanelService extends BaseService<Panel, PanelDao>
{
    PanelDao panelDao = new PanelDao();
    public PanelService()
    {
       super(PanelDao.class);
    }
    public List<Panel> findAllbyAnketID(Long id) {
        return panelDao.findAllbyAnketID(id);
    }

}