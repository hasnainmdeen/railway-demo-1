package com.aws.codestar.projecttemplates.service;

import com.aws.codestar.projecttemplates.model.CheckConflictRequest;
import com.aws.codestar.projecttemplates.model.TrackSection;

import java.util.List;

public interface PathFinderService {
    public List<TrackSection> findPath(List<TrackSection> stationGraph, TrackSection checkRoute);
    public boolean checkConflicts(CheckConflictRequest request);

    public boolean sectionExistInPath(List<TrackSection> path, TrackSection section);

    public int add (int a, int b);
}
