package com.hpfs.distillery.retailer.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.hpfs.distillery.retailer.dto.LabSampleDto;
import com.hpfs.distillery.retailer.dto.UserDetails;
import com.hpfs.distillery.retailer.model.LabInformation;
import com.hpfs.distillery.retailer.model.LabSample;
import com.hpfs.distillery.retailer.repository.LabInformationRepository;
import com.hpfs.distillery.retailer.repository.LabSamplesRepository;
import com.hpfs.distillery.retailer.utils.AttachmentUtils;
import com.hpfs.distillery.retailer.utils.DtoToModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LabDetailsServiceImpl implements LabDetailsService {

	@Resource
	private LabSamplesRepository labSamplesRepository;

	@Resource
	private LabInformationRepository labInformationRepository;

	DtoToModel dtoToModel = new DtoToModel();
	ModelMapper modelMapper = new ModelMapper();

	@Override
	public LabSample saveLabSamples(LabSampleDto requestData, UserDetails us)
			throws SerialException, SQLException, IOException {
		LabSample labSample;
		labSample = labSamplesRepository.save(dtoToModel.toLabSample(requestData,us));
		return labSample;
	}

	@Override
	public List<LabSample> fetchAllSamples() throws IOException {
		List<LabSample> labSampleList = labSamplesRepository.findAll();
		List<LabSample> newLabSampleList = new ArrayList<>();
		if (labSampleList != null) {

			for (LabSample d : labSampleList) {
				byte[] signature = d.getData();
				d.setSignatureFile(AttachmentUtils.decompress(signature));
				if (!d.getLabInformation().isEmpty()) {
					d.setLabInformation(buildLabInformation(d.getLabInformation()));
				}
				newLabSampleList.add(d);
			}

		}
		return newLabSampleList;
	}

	private List<LabInformation> buildLabInformation(List<LabInformation> labInformationList) throws IOException {
		List<LabInformation> newLabInformationList = new ArrayList<>();
		for (LabInformation d : labInformationList) {

			byte[] compressed = d.getData();
			d.setDataFile(AttachmentUtils.decompress(compressed));
			newLabInformationList.add(d);
		}

		return newLabInformationList;

	}

	@Override
	public LabInformation updateStatus(int labInfoId, String status) {
		LabInformation labInformation = labInformationRepository.findByLabInformationId(labInfoId);
		if (labInformation != null) {
			labInformation.setStatus(status);
			labInformation = labInformationRepository.save(labInformation);

		}

		return labInformation;
	}
}
